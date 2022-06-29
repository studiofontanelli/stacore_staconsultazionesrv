package it.csi.stacore.staconsultazionesrv.util.adapter;

import java.io.Serializable;
import java.util.List;

import it.csi.stacore.staconsultazionesrv.util.Constants;
import it.csi.stacore.staconsultazionesrv.util.adapter.exception.DtoConversionException;

public interface DtoAdapterInterface <T,V> extends Serializable {


	public static final String LOGGER_PREFIX = Constants.LOGGER_PREFIX + ".util.adapter";

	public V convertTo(T t) throws DtoConversionException;

	public T convertFrom(V v) throws DtoConversionException ;

	public List<V> convertTo(List<T> tList) throws DtoConversionException ;

	public List<T> convertFrom(List<V> vList) throws DtoConversionException ;

}

