from app.core.use_cases.process_payment import ProcessPayment

class PaymentService:
    def process_payment(self, id_pedido):
        return ProcessPayment.execute(id_pedido)
