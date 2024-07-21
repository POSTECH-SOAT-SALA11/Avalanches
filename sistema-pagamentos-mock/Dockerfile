# Use uma imagem base do Python
FROM python:3.9-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o código-fonte do projeto para o contêiner
COPY sistema-pagamentos-mock/ /app/sistema-pagamentos-mock/

# Defina a variável de ambiente para o Flask
ENV FLASK_APP=/app/sistema-pagamentos-mock/main_app.py

# Instale as dependências do Python
COPY sistema-pagamentos-mock/requirements.txt /app/requirements.txt
RUN pip install --no-cache-dir -r /app/requirements.txt

# Exponha a porta 5001
EXPOSE 5001

# Comando para iniciar a aplicação Flask quando o contêiner for iniciado
CMD ["flask", "run", "--host=0.0.0.0"]
