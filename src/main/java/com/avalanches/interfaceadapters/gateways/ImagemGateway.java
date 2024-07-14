package com.avalanches.interfaceadapters.gateways;


import com.avalanches.enterprisebusinessrules.entities.Imagem;
import com.avalanches.interfaceadapters.gateways.interfaces.ImagemGatewayInterface;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

@Repository
public class ImagemGateway implements ImagemGatewayInterface {

    public static final String IMAGENS = "imagens";
    // TODO: pesquisar como fazer no springboot via interface

    private JdbcOperations jdbcOperations;

    public ImagemGateway(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void cadastrar(Imagem imagem) {
        criarArquivo(imagem);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(
                                "INSERT INTO imagem(nome, descricao, tipoconteudo, caminho, tamanho) VALUES (?, ?, ?, ?, ?);",
                                Statement.RETURN_GENERATED_KEYS
                        );
                        ps.setString(1, imagem.nome);
                        ps.setString(2, imagem.descricao);
                        ps.setString(3, imagem.tipoConteudo);
                        ps.setString(4, imagem.caminho);
                        ps.setInt(5, imagem.tamanho);
                        return ps;
                    }
                },
                keyHolder
        );
        imagem.id = (int) keyHolder.getKeys().get("id");
    }

    @Override
    public void atualizar(Imagem imagem) {
        editarArquivo(imagem);
        jdbcOperations.update("UPDATE imagem SET nome=?, descricao=?, tipoconteudo=?, caminho=?, tamanho=? WHERE id=(?);",
                imagem.nome,
                imagem.descricao,
                imagem.tipoConteudo,
                imagem.caminho,
                imagem.tamanho,
                imagem.id
        );
    }

    @Override
    public void excluir(Imagem imagem) {
        jdbcOperations.update("DELETE FROM imagem WHERE id=?", imagem.id);

        if (imagem.caminho != null) {
            Path imagePath = Paths.get(IMAGENS).resolve(imagem.caminho);
            try {
                Files.deleteIfExists(imagePath);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao deletar arquivo.", e);
            }
        }
    }

    private static void criarArquivo(Imagem imagem) {
        Path imagesFolder = Paths.get(IMAGENS);
        if (!Files.exists(imagesFolder)) {
            try {
                Files.createDirectories(imagesFolder);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao criar pasta 'imagens'.", e);
            }
        }
        imagem.caminho = UUID.randomUUID().toString();
        Path imagePath = imagesFolder.resolve(imagem.caminho);
        try {
            Files.createFile(imagePath);
            editarArquivo(imagem);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar arquivo.", e);
        }
    }

    private static void editarArquivo(Imagem imagem) {
        Path imagesFolder = Paths.get(IMAGENS);
        Path imagePath = imagesFolder.resolve(imagem.caminho);
        if (!Files.exists(imagesFolder) || !Files.exists(imagePath)) {
            throw new NotFoundException("Arquivo não existe");
        }

        try {
            Files.write(imagePath, imagem.conteudo);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao editar arquivo.", e);
        }
    }


    @Override
    public byte[] lerArquivo(String path) {
        Path imagePath = Paths.get(IMAGENS + '/' + path);

        byte[] file;

        try {
            file = Files.readAllBytes(imagePath);
        } catch(IOException e){
            throw new RuntimeException("Arquivo não encontrado.", e);
        }

        return file;
    }

}
