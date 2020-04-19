package com.marcnuri.yakc.model;

import java.util.List;

/**
 * Created by Marc Nuri on 2020-04-13.
 */
public interface ListModel<T> extends Model {

  List<T> getItems();
}
