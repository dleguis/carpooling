package edu.fst.m2.ipii.carpooling.transverse.utils.mapper;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.hibernate.Hibernate;

/**
 * Projet Bookstore (FST)
 * Créé par Dimitri le 23/11/14.
 * FieldMapper Dozer permettant de mettre a null les collections Lazy Hibernate non initialisees
 */
public class DozerInitializedFieldMapper implements CustomFieldMapper {

    /*
     * (non-Javadoc)
     *
     * @see org.dozer.CustomFieldMapper#mapField(java.lang.Object,
     * java.lang.Object, java.lang.Object, org.dozer.classmap.ClassMap,
     * org.dozer.fieldmap.FieldMap)
     */
    @Override
    public boolean mapField(Object source, Object destination, Object sourceFieldValue, ClassMap classMap, FieldMap fieldMapping) {

	    return !Hibernate.isInitialized(sourceFieldValue);
    }
}
