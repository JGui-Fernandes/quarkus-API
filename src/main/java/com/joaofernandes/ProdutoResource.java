package com.joaofernandes;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> buscarTodosProdutos(){
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void cadastrarProduto(CadastraProdutoRequest cadastraProdutoRequest){
        Produto produto = new Produto();
        produto.nome = cadastraProdutoRequest.nome();
        produto.valor = cadastraProdutoRequest.valor();
        produto.persist();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void atualizaProduto(@PathParam("id") Long id, AtualizaProdutoRequest atualizaProdutoRequest){
        Optional<Produto> produto = Produto.findByIdOptional(id);

        if(produto.isPresent()){
            Produto p = produto.get();

            p.nome = atualizaProdutoRequest.nome();
            p.valor = atualizaProdutoRequest.valor();

            p.persist();
        } else{
            throw new NotFoundException("ID de produto não encontrado!");
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletaProduto(@PathParam("id") Long id){
        Optional<Produto> produto = Produto.findByIdOptional(id);

        if(produto.isPresent()){
            Produto p = produto.get();

            p.delete();
        } else{
            throw new NotFoundException("ID de produto não encontrado!");
        }
    }
}
