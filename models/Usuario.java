package models;

import interfaces.IThreadService;

abstract class Usuario implements IThreadService {
    private int id;
    private String nomeUsr;
    private String nome;
    private String email;
    private boolean isAtivo;
}
