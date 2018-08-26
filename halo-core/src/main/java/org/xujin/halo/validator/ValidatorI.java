
package org.xujin.halo.validator;

/**
 * Validator Interface
 * @author xujin 2017-11-04
 */
public interface ValidatorI {
    
    /**
     * Validate candidate, throw according exception if failed
     * @param candidate candidate param
     */
    public void validate(Object candidate);

}
