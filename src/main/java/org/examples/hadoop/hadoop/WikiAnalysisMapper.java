/**
 * @author nirmoho-Mac
 *
 */
package org.examples.hadoop.hadoop;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class WikiAnalysisMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    
    public void map(LongWritable key, Text value, Context context)  {
        String line = value.toString();
        
        String[] lineParts = line.split(" ");
        
    }
    

}
