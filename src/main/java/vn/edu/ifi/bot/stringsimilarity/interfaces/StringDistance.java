package vn.edu.ifi.bot.stringsimilarity.interfaces;

import java.io.Serializable;

/**
 *
 * @author Thibault Debatty
 */
public interface StringDistance extends Serializable {

    /**
     * Compute and return a measure of distance.
     * Must be &gt;= 0.
     * @param s1
     * @param s2
     * @return
     */
    double distance(String s1, String s2);
}
