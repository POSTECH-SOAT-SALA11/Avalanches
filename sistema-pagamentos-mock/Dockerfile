# Use uma imagem base do Python
FROM python:3.9-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o código-fonte do projeto para o contêiner
COPY . /app/

# Instale as dependências do Python
RUN pip install --no-cache-dir -r /app/requirements.txt

# Defina a variável de ambiente para o Flask
ENV FLASK_APP=/app/main.py

# Exponha a porta 5001
EXPOSE 5001

# Comando para iniciar a aplicação Flask quando o contêiner for iniciado
CMD ["flask", "run", "--host=0.0.0.0", "--port=5001"]
