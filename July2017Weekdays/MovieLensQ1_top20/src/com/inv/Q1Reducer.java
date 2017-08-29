package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q1Reducer extends Reducer<FloatWritable, Text, Text, Text> {
	int count=0;
	@Override
	protected void reduce(FloatWritable key, Iterable<Text> values, Reducer<FloatWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		////1@4.0@Toy Story (1995)
		if(count<20){
			for (Text val : values) {
				context.write(val,new Text());
			}
		}
		count=count+1;
		
	}

}
