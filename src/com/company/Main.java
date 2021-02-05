package com.company;

import com.company.protocoles.Protocole;
import com.company.protocoles.ProtocoleCesar;
import com.company.protocoles.ProtocoleTransposition;
import com.company.protocoles.ProtocoleVigenere;

public class Main {



    public static void main(String[] args) {
        Protocole protCesar = new ProtocoleCesar();
        protCesar.executer();

        Protocole protTransposition = new ProtocoleTransposition();
        protTransposition.executer();

        Protocole protVigenere = new ProtocoleVigenere();
        protVigenere.executer();
    }
}
