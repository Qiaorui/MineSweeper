package com.mineSweeper.domainLayer.dataInterface;

import java.util.List;

import com.mineSweeper.domainLayer.domainModel.Nivell;

/**
 * Created by qiaorui on 14-10-28.
 */
public interface CtrlNivell {

    public Nivell getNivell(String nom);

    public List<Nivell> getAll();
}
