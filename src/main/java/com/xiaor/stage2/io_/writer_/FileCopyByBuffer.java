package com.xiaor.stage2.io_.writer_;

import java.io.*;

public class FileCopyByBuffer {
    public static void main(String[] args)   {

        String srcFilePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\new_file1.txt";
        String destFilePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\new_file1_copy.txt";

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(srcFilePath));
            bufferedWriter =new BufferedWriter(new FileWriter(destFilePath, true));

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();     // 将读取的内容写入文件
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
