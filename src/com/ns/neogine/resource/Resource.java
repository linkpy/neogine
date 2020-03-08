package com.ns.neogine.resource;

import com.ns.neogine.exception.ResourceException;

/**
 * Base class for all resources.
 */
public abstract class Resource {
	/**
	 * Loads the resource.
	 *
	 * @throws ResourceException when an error occures while loading
	 *                           the resource.
	 */
	public abstract void load() throws ResourceException;

	/**
	 * Unloads the resource.
	 */
	public abstract void unload();
}
