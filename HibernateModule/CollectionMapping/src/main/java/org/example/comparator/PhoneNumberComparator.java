package org.example.comparator;

import org.example.entities.PhoneNumber;
import java.util.Comparator;

/**
 * Implements a comparator for {@link PhoneNumber} objects.
 * This comparator compares two phone numbers by their number values.
 */
public class PhoneNumberComparator implements Comparator<PhoneNumber> {

    /**
     * Compares two {@link PhoneNumber} objects by their number values.
     *
     * @param o1 the first {@link PhoneNumber} to be compared.
     * @param o2 the second {@link PhoneNumber} to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     */
    @Override
    public int compare(PhoneNumber o1, PhoneNumber o2) {
        return o1.getNumber().compareTo(o2.getNumber());
    }
}
