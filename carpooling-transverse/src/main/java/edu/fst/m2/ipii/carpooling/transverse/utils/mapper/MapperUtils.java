package edu.fst.m2.ipii.carpooling.transverse.utils.mapper;

import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dimitri on 02/11/14.
 */
public class MapperUtils {

    /**
     * Map.
     *
     * @param <T>      the generic type
     * @param mapper   the mapper
     * @param source   the source
     * @param destType the dest type
     * @return the t
     */
    public static <T> T map(final Mapper mapper, final Object source, final Class<T> destType) {
		if (source == null) {
			return null;
		} else {
			return mapper.map(source, destType);
		}
    }

    /**
     * Map.
     *
     * @param <T> the generic type
     * @param <U> the generic type
     * @param mapper the mapper
     * @param source the source
     * @param destType the dest type
     * @return the list
     */
    public static <T, U> List<U> map(final Mapper mapper, final List<T> source, final Class<U> destType) {

		final ArrayList<U> dest = new ArrayList<U>();

		for (T element : source) {
			if (element == null) {
				continue;
			}
			dest.add(mapper.map(element, destType));
		}

		// finally remove all null values if any
		List s1 = new ArrayList();
		s1.add(null);
		dest.removeAll(s1);

		return dest;
    }

    /**
     * Map.
     *
     * @param <T> the generic type
     * @param <U> the generic type
     * @param mapper the mapper
     * @param source the source
     * @param destType the dest type
     * @return the collection
     */
    public static <T, U> Collection<U> map(final Mapper mapper, final Collection<T> source, final Class<U> destType) {

		final Collection<U> dest = new ArrayList<U>();

		for (T element : source) {
			if (element == null) {
				continue;
			}
			dest.add(mapper.map(element, destType));
		}

		// finally remove all null values if any
		List s1 = new ArrayList();
		s1.add(null);
		dest.removeAll(s1);

		return dest;
    }
}
