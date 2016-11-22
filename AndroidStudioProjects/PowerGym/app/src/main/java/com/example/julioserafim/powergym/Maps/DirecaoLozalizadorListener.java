package com.example.julioserafim.powergym.Maps;

import java.util.List;

/**
 * Created by julioserafim on 11/22/16.
 */

public interface DirecaoLozalizadorListener {
    void onDirectionLocalizadorStart();
    void onDirectionLocalizadorSuccesso(List<Rota> rota);
}
