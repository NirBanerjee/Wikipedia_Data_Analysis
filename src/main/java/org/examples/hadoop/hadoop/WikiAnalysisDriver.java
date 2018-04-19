/**
 * @author nirmoho-Mac
 *
 */
package org.examples.hadoop.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

public class WikiAnalysisDriver {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "Wiki Data Set Analysis");
        
        

    }

}
