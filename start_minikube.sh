#!/bin/bash

# Iniciar o Minikube
echo "Iniciando Minikube..."
minikube start

echo "Habilitando o metrics-server..."
minikube addons enable metrics-server

# Aplicar arquivos YAML do Kubernetes
echo "Aplicando arquivos YAML do Kubernetes..."
kubectl apply -f kubernetes/

# Aguardar um pouco para os pods começarem a inicializar
echo "Aguardando os pods inicializarem..."
sleep 30  # Ajuste o tempo conforme necessário

# Chamar os scripts de port-forwarding
echo "Iniciando o port-forwarding para avalanches-app..."
./port_forward_avalanches.sh &

echo "Iniciando o port-forwarding para sistema-pagamentos-mock..."
./port_forward_sistema_pagamentos_mock.sh &
