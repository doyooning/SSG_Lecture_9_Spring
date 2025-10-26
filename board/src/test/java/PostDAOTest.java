import com.ssg.board.dao.PostDAO;
import com.ssg.board.dao.PostDAOImpl;
import com.ssg.board.domain.PostVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class PostDAOTest {
    private PostDAO postDAO;

    @BeforeEach
    public void ready() {
        postDAO = new PostDAOImpl();
    }

    @Test
    void testFindAll() {
        List<PostVO> postVOList = postDAO.findAll();
        for (PostVO postVO : postVOList) {
            System.out.println(postVO.toString());
        }
    }

    @Test
    void testFindById() {
        Optional<PostVO> postVO = postDAO.findById(1);
        System.out.println(postVO.isPresent());
    }

    @Test
    void testSave() {
        PostVO postVO = PostVO.builder()
                .title("title")
                .content("content")
                .writer("writer")
                .passphrase("1234")
                .build();
        long save = postDAO.save(postVO);
        System.out.println(postVO.toString());
        System.out.println("새 게시물 ID: " + save);
    }

    @Test
    void testUpdate() {
        PostVO postVO = PostVO.builder()
                .postId(1L)
                .title("newtitle")
                .content("newcontent")
                .writer("writer")
                .build();
        boolean update = postDAO.update(postVO);
        System.out.println(postVO.toString());
        System.out.println("update: " + update);
    }

    @Test
    void testDelete() {
        boolean delete = postDAO.delete(1);
        System.out.println(delete);
    }

    @Test
    void testCheckPassphrase() {
        long id = 1L;
        String passphrase1 = "1234"; // 참
        String passphrase2 = "5678"; // 거짓
        System.out.println(postDAO.checkPassphrase(id, passphrase1));
        System.out.println(postDAO.checkPassphrase(id, passphrase2));
    }

}
