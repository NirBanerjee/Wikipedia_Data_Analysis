/**
 * @author nirmoho-Mac
 *
 */
package org.examples.hadoop.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WikiAnalysisReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
    
    private IntWritable count = new IntWritable();
    
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        
        for(IntWritable val : values)   {
            sum = sum + val.get();
        }
        
        count.set(sum);
        context.write(key, count);
    }

}
