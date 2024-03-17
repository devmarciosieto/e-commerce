package br.com.mmmsieto.order.app.v1.controller.dtos;

public class OrderResponse {

    private String customer;
    private String address;
    private String carrier;
    private String delivery;
    private String payment;
    private String restriction;
    private String stock;
    private String fraud;
    private String validation;

    public OrderResponse() {
    }

    public OrderResponse(
            String customer,
            String address,
            String carrier,
            String delivery,
            String payment,
            String restriction,
            String stock,
            String fraud,
            String validation) {
        this.customer = customer;
        this.address = address;
        this.carrier = carrier;
        this.delivery = delivery;
        this.payment = payment;
        this.restriction = restriction;
        this.stock = stock;
        this.fraud = fraud;
        this.validation = validation;
    }

    private OrderResponse(Builder builder) {
        this.customer = builder.customer;
        this.address = builder.address;
        this.carrier = builder.carrier;
        this.delivery = builder.delivery;
        this.payment = builder.payment;
        this.restriction = builder.restriction;
        this.stock = builder.stock;
        this.fraud = builder.fraud;
        this.validation = builder.validation;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getFraud() {
        return fraud;
    }

    public void setFraud(String fraud) {
        this.fraud = fraud;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "customer='" + customer + '\'' +
                ", address='" + address + '\'' +
                ", carrier='" + carrier + '\'' +
                ", delivery='" + delivery + '\'' +
                ", payment='" + payment + '\'' +
                ", restriction='" + restriction + '\'' +
                ", stock='" + stock + '\'' +
                ", fraud='" + fraud + '\'' +
                ", validation='" + validation + '\'' +
                '}';
    }

    public static class Builder {
        private String customer;
        private String address;
        private String carrier;
        private String delivery;
        private String payment;
        private String restriction;
        private String stock;
        private String fraud;
        private String validation;

        public Builder customer(String customer) {
            this.customer = customer;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder carrier(String carrier) {
            this.carrier = carrier;
            return this;
        }

        public Builder delivery(String delivery) {
            this.delivery = delivery;
            return this;
        }

        public Builder payment(String payment) {
            this.payment = payment;
            return this;
        }

        public Builder restriction(String restriction) {
            this.restriction = restriction;
            return this;
        }

        public Builder stock(String stock) {
            this.stock = stock;
            return this;
        }

        public Builder fraud(String fraud) {
            this.fraud = fraud;
            return this;
        }

        public Builder validation(String validation) {
            this.validation = validation;
            return this;
        }

        public OrderResponse build() {
            return new OrderResponse(this);
        }
    }

}
