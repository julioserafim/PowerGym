package com.example.julioserafim.powergym.Model;

import java.util.List;

/**
 * Created by julioserafim on 11/18/16.
*/

public class AcademiasEmQuixada {
    private List<Academia> academias;

    public AcademiasEmQuixada(){
        academias.add(new Academia("Hot Line Academia",-4.969664, -39.008363,"Tv. Sebastião Holanda, 2 - Irajá, Quixadá - CE, 63900-000"));
        academias.add(new Academia("Mega Light",-4.969986, -39.010636," R. Prof. Júlio Holanda, 270 - Alto São Francisco, Quixadá - CE, 63900-000"));
        academias.add(new Academia("Imperius Fitness",-4.970154, -39.016156,"Av. Plácido Castelo, 1815 - Centro"));
        academias.add(new Academia("Fisico Academia Feminina",-4.967722, -39.016108,"R. Pres. Vargas, 2090 - Centro, Quixadá - CE, 63900-000"));
        academias.add(new Academia("World Fitness",-4.964397, -39.025083,"R. Joaquim Gomes da Silva, 2591 - Planalto Universitário, Quixadá - Ceará"));
    }
}
