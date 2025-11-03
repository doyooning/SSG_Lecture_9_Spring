package springboard.mappers;


import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import com.ssg.springboard.mappers.ReplyMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class ReplyMapperTests {

  @Autowired(required = false)
  ReplyMapper replyMapper;

  @Test
  public void test1() {
    log.info(replyMapper);
  }

  @Test
  public void testList() {

//    replyMapper.getList().forEach(replyVO -> log.info(replyDTO));

  }

  @Test
  public void testInsert() {
    Long bno = 683L;

    for (int i = 0; i < 20; i++) {
      ReplyVO replyVO = ReplyVO.builder()
              .bno(bno)
              .replyText("replyText: " + i)
              .replier("gdgd")
              .build();
      log.info(replyMapper.insert(replyVO));
    }

  }

  @Test
  public void testSelect() {

    Long rno = 9L;

    log.info(replyMapper.selectOne(rno));

  }

  @Test
  public void testUpdate() {
    ReplyVO replyVO = ReplyVO.builder()
            .rno(4L)
            .replyText("---updated---")
            .build();

    log.info(replyMapper.updateOne(replyVO));
  }

  @Test
  public void testDelete() {
    Long rno = 4L;
    log.info(replyMapper.deleteOne(rno));
  }

  @Test
  public void testSelectAll() {
    Criteria cri = new Criteria();

    replyMapper.getReplyList(cri, 683L).forEach(replyVO -> log.info(replyVO));
  }


  @Test
  public void testPage() {

//    Criteria criteria = new Criteria();
//    criteria.setPageNum(2);
//    criteria.setTypes(new String[]{"T"});
//    criteria.setKeyword("1");
//    java.util.List<BoardVO> list = replyMapper.getPage(criteria);
//
//    list.forEach(boardVO -> log.info(boardVO));
  }

}
