#!/bin/bash

# Função para aguardar até que o pod esteja pronto
wait_for_pod_ready() {
    local pod_label=$1
    echo "Aguardando o pod com label '$pod_label' estar pronto..."

    while true; do
        POD_NAME=$(kubectl get pods -l app=$pod_label -o jsonpath="{.items[0].metadata.name}")

        if [ -z "$POD_NAME" ]; then
            echo "Nenhum pod encontrado para o label '$pod_label'. Verifique o label e a configuração."
            exit 1
        fi

        READY_STATUS=$(kubectl get pod $POD_NAME -o jsonpath="{.status.conditions[?(@.type=='Ready')].status}")

        if [[ $READY_STATUS == "True" ]]; then
            break
        fi

        echo "Aguardando o pod $pod_label estar pronto..."
        sleep 5
    done
}

# Esperar o pod avalanches estar pronto
wait_for_pod_ready "avalanches"

# Obter o nome do pod avalanches
POD_NAME=$(kubectl get pods -l app=avalanches -o jsonpath="{.items[0].metadata.name}")

# Configurar o port forwarding para avalanches
PORT=8080
echo "Configurando port forwarding para avalanches na porta $PORT..."
kubectl port-forward pod/$POD_NAME $PORT:$PORT
