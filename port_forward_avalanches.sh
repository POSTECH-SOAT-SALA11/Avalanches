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

# Função para configurar o port forwarding
setup_port_forward() {
    local pod_label=$1
    local port=$2

    while true; do
        wait_for_pod_ready "$pod_label"

        POD_NAME=$(kubectl get pods -l app=$pod_label -o jsonpath="{.items[0].metadata.name}")

        echo "Configurando port forwarding para o pod $POD_NAME na porta $port..."
        kubectl port-forward pod/$POD_NAME $port:$port

        echo "Port forwarding para o pod $POD_NAME foi interrompido. Tentando novamente..."
        sleep 5
    done
}

# Definir as variáveis
POD_LABEL="avalanches"
PORT=8080

# Configurar o port forwarding e manter verificando
setup_port_forward "$POD_LABEL" "$PORT"
