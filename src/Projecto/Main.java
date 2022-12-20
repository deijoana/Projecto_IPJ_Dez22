package Projecto;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Empresa empresa = new Empresa();

        GUI frame = new GUI(empresa);

    }

}