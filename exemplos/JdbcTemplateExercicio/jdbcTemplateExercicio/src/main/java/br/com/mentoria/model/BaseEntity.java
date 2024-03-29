package br.com.mentoria.model;

import java.io.Serializable;

public abstract class BaseEntity<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected T id;
	
	public void setId(T id) {
		this.id = id;
	}
	
	public static String getEntityName(Object obj) {
		BaseEntity<?> other = (BaseEntity<?>) obj;
		return other.getClass().getSimpleName().toUpperCase();
	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity<?> other = (BaseEntity<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
