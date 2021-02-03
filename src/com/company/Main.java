package com.company;

import com.company.protocoles.Protocole;
import com.company.protocoles.ProtocoleCesar;
import com.company.protocoles.ProtocoleTransposition;

public class Main {



    public static void main(String[] args) {
        Protocole protCesar = new ProtocoleCesar();
        protCesar.executer();

        Protocole protTransposition = new ProtocoleTransposition();
        protTransposition.executer();
    }
}
