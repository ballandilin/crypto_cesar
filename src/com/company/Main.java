package com.company;

import com.company.protocoles.*;

public class Main {



    public static void main(String[] args) {
        Protocole protCesar = new ProtocoleCesar();
        protCesar.executer();

        Protocole protTransposition = new ProtocoleTransposition();
        protTransposition.executer();

        Protocole protVigenere = new ProtocoleVigenere();
        protVigenere.executer();

        Protocole protSubstition = new ProtocoleSubstitution();
        protSubstition.executer();
    }
}
