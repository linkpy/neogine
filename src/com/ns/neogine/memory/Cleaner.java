package com.ns.neogine.memory;

import java.util.LinkedList;


/**
 * Cleaner class, manages a list of reference-counted object.
 * Objects are destroyed in the reverse order they were added.
 */
public class Cleaner {
	/**
	 * List of managed reference-counted objects.
	 */
	private LinkedList<Reference> _objects;


	/**
	 * Constructor.
	 */
	public Cleaner() {
		_objects = new LinkedList<>();
	}


	/**
	 * Adds the given object to the cleaner. The object's acquired, increasing
	 * its reference count. If the object is null or already destroyed, nothing
	 * is done.
	 */
	public <T extends Reference> T add(T ref) {
		if( ref == null || !ref.isActive() )
			return null;

		_objects.push(ref.acquire());
		return ref;
	}

	/**
	 * Removes the given object from the cleaner. The object's released,
	 * decreasing its reference count if it was already managed by the cleaner.
	 */
	public Cleaner remove(Reference ref) {
		if( _objects.remove(ref) )
			ref.release();

		return this;
	}

	/**
	 * Clears the object list. All active objects are released.
	 */
	public Cleaner clear() {
		for( Reference ref : _objects ) {
			if( ref.isActive() )
				ref.release();
		}

		_objects.clear();
		return this;
	}

	/**
	 * Cleans the object list. All active objects are destroyed.
	 */
	public Cleaner clean() {
		for( Reference ref : _objects ) {
			if( ref.isActive() )
				ref.destroy();
		}

		_objects.clear();
		return this;
	}
}
