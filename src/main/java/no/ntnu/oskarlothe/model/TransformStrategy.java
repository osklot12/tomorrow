package no.ntnu.oskarlothe.model;

/**
 * An interface for all classes that transform environments.
 * All classes implementing the TransformStrategy interface is a part of the
 * Strategy pattern for transforming environments.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface TransformStrategy {
    /**
     * Transforms an environment into another.
     * 
     * @return the transformed environment
     */
    Environment transform();
}
