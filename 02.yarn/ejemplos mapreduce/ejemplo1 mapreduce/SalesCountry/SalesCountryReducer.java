package SalesCountry;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class SalesCountryReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        int frequencyForCountry = 0;
        while (values.hasNext()) {
            frequencyForCountry += values.next().get();
        }
        output.collect(key, new IntWritable(frequencyForCountry));
    }
}