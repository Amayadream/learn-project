import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;

import java.io.IOException;

/**
 * @author :  Amayadream
 * @date :  2016.03.26 15:28
 */
public class LuceneTest {

    @Test
    public void test() throws IOException, ParseException {
        Analyzer analyzer = new SimpleAnalyzer();
        //将索引存储到内存中
        Directory directory = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(directory, config);
        String[] texts = new String[]{
                "Mybatis分页插件 - 示例",
                "Mybatis 贴吧问答 第一期",
                "Mybatis 示例之 复杂(complex)属性(property)",
                "Mybatis极其(最)简(好)单(用)的一个分页插件",
                "Mybatis 的Log4j日志输出问题 - 以及有关日志的所有问题",
                "Mybatis 示例之 foreach （下）",
                "Mybatis 示例之 foreach （上）",
                "Mybatis 示例之 SelectKey",
                "Mybatis 示例之 Association (2)",
                "Mybatis 示例之 Association"
        };
        for (String text : texts) {
            Document doc = new Document();
            doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
            writer.addDocument(doc);
        }
        writer.close();

        //读取索引并查询
        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        //解析一个简单的查询
        QueryParser parser = new QueryParser("fieldname", analyzer);
        Query query = parser.parse("property");
        ScoreDoc[] hits = searcher.search(query, null, 1000).scoreDocs;
        //迭代输出结果
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = searcher.doc(hits[i].doc);
            System.out.println(hitDoc.get("fieldname"));
        }
        reader.close();
        directory.close();
    }
}
