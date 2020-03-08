package com.ns.neogine.memory;


/**
 * Reference-counted object with self-managed memory.
 */
public abstract class Reference {
	/**
	 * False if the object was destroyed.
	 */
	private boolean _active;
	/**
	 * Number of time the object was referenced.
	 */
	private int _count;


	/**
	 * Constructor.
	 */
	public Reference() {
		_active = true;
		_count = 1;
	}


	/**
	 * Returns false if the object was already destroyed.
	 */
	public boolean isActive() {
		return _active;
	}

	/**
	 * Gets the number of time the object was referenced.
	 */
	public int getReferenceCount() {
		return _count;
	}


	/**
	 * Acquires the object. Increases by one the reference count.
	 */
	public Reference acquire() {
		// if the object was already destroyed.
		if( !_active )
			throw new IllegalStateException("The object is destroyed.");

		_count++;
		return this;
	}

	/**
	 * Releases the object. Decreases by one the reference count.
	 */
	public void release() {
		// if the object was already destroyed.
		if( !_active )
			throw new IllegalStateException("The object is destroyed.");

		_count--;

		if( _count <= 0 ) {
			destroy();
		}
	}


	/**
	 * Destroys the object, whatever is the reference count. Should be used
	 * with caution.
	 */
	public void destroy() {
		if( !_active )
			throw new IllegalStateException("The object is destroyed.");

		_active = false;
		_destroy();
	}

	/**
	 * Destroys the object. Implementation.
	 */
	protected abstract void _destroy();


	/**
	 * Invalidates the object. Used when the construction of it failed.
	 */
	protected void invalidate() {
		_active = false;
		_count = -1;
	}
}
