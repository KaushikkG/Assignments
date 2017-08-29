package com.inv;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<Text, Text, Text, Text>{

	//byte offset , line keyin and value in
	// Word , 1 -> kout, vout
	@Override
	protected void map(Text key, Text value, Mapper<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {

		
			context.write(new Text(key.toString()+"_##"), value);
		
	
	}
	
	
}
