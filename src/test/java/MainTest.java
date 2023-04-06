import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import java.util.Deque;

public class MainTest {

    @Test
    void Deque_테스트() {
        Deque<String> myStack = new ArrayDeque<>();
        myStack.push("I am the 1st element.");
        myStack.push("I am the 2nd element.");
        myStack.push("I am the 3rd element.");

        assertThat(myStack.size()).isEqualTo(3);

        //insert element to the bottom of the stack
        myStack.addLast("I am the NEW element.");
        assertThat(myStack.size()).isEqualTo(4);
        assertThat(myStack.peek()).isEqualTo("I am the 3rd element.");

        //remove element from the bottom of the stack
        String removedStr = myStack.removeLast();
        assertThat(myStack.size()).isEqualTo(3);
        assertThat(removedStr).isEqualTo("I am the NEW element.");
    }

    @Test
    void assertThat_테스트() {
        assertThat(1).isEqualTo(1);
        assertThat(2).isEqualTo(20);
        assertThat(3).isEqualTo(3);
        assertThat(4).isEqualTo(40);
    }

    @Test
    void assertAll_테스트() {
        assertAll(
                () -> assertThat(1).isEqualTo(1),
                () -> assertThat(2).isEqualTo(20),
                () -> assertThat(3).isEqualTo(3),
                () -> assertThat(4).isEqualTo(40)
        );
    }

    @Test
    void assertSoftly_테스트() {
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(1).isEqualTo(1);
            softAssertions.assertThat(2).isEqualTo(22);
            softAssertions.assertThat(3).isEqualTo(3);
            softAssertions.assertThat(4).isEqualTo(44);
        });
    }
}
