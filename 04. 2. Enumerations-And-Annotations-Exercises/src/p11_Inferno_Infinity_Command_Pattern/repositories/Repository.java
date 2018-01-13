package p11_Inferno_Infinity_Command_Pattern.repositories;

import p11_Inferno_Infinity_Command_Pattern.models.api.WeaponInterface;
import p11_Inferno_Infinity_Command_Pattern.models.api.WeaponInterface;

import java.util.Map;

public interface Repository<T> {

    void add(T element);

    Map<String, WeaponInterface> findAll();
}
