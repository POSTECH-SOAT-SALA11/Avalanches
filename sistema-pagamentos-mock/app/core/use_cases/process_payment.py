class ProcessPayment:
    @staticmethod
    def execute(id_pedido):
        return "aprovado" if int(id_pedido) % 2 == 0 else "reprovado"
