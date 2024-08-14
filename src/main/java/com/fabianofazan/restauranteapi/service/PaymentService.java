package com.fabianofazan.restauranteapi.service;

import com.fabianofazan.restauranteapi.models.dto.PaymentDto;
import com.fabianofazan.restauranteapi.models.entities.PaymentEntities;
import com.fabianofazan.restauranteapi.models.enums.TypePayment;
import com.fabianofazan.restauranteapi.models.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentEntities create(PaymentEntities paymentEntities) {
        return paymentRepository.save(paymentEntities);
    }


    public List<PaymentEntities> getAll() {
        return paymentRepository.findAll();
    }


    public PaymentEntities getById(UUID id) {
        return paymentRepository.findById(id).orElse(null);
    }


    public PaymentEntities update(UUID id, PaymentDto paymentDto) {
        PaymentEntities existingPayment = paymentRepository.findById(id).orElse(null);
        if (existingPayment != null) {
            existingPayment.setAmountPaid(paymentDto.amount());
            existingPayment.setValue(paymentDto.value());
            existingPayment.setTypePayment(paymentDto.typePayment());
            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    public void delete(UUID id) {
        paymentRepository.deleteById(id);
    }

    public String procPayment (PaymentEntities paymentEntities) {
        TypePayment typePayment = paymentEntities.getTypePayment();
        switch (typePayment) {
            case CreditCard:
                return procCreditCard((paymentEntities));
            case Pix:
                return procPix((paymentEntities));
            case Money:
                return  procMoney((paymentEntities));
            default:
                throw new IllegalArgumentException("Tipo de pagamento inválido");
        }
    }
   private String procCreditCard(PaymentEntities paymentEntities) {
       return "Pagamento com cartão de crédito processado com sucesso";
   }

   private String procPix(PaymentEntities paymentEntities) {
       return "Pagamento via pix processado com sucesso";
   }

   private String procMoney(PaymentEntities paymentEntities) {
        double amountPaid = paymentEntities.getAmountPaid();
        double orderValue = paymentEntities.getValue();
        double cValue = amountPaid - orderValue;

        if (cValue < 0.0) {
            return "Pagamento em dinheiro inferiror ao valor do pedido! Não ha troco";
        } else if (cValue == 0.0) {
            return "Pagamento em dinheiro processado com sucesso! Não há troco";
        } else {
            return String.format("Pagamento em dinheiro processado com sucesso! Seu troco é de R$%.2f.", cValue);
        }
   }
}