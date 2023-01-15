package com.example.denysenkojetpackcompose

import androidx.lifecycle.ViewModel
import com.example.denysenkojetpackcompose.model.Cartoon
import kotlinx.coroutines.flow.MutableStateFlow

class CatroonData : ViewModel() {
    private val _anime = MutableStateFlow<List<Cartoon>>(emptyList())
    val anime = _anime

    fun getById(id: String): Cartoon {
        return _anime.value.filter { it.id == id }.first()
    }

    init {
        _anime.value = mutableListOf(
            Cartoon(
                "1",
                "Frozen",
                "Disney",
                R.drawable.frozen,
                2013,
                "Fearless optimist Anna teams up with rugged mountain man Kristoff and his loyal reindeer Sven and sets off on an epic journey to find her sister Elsa"
            ),
            Cartoon(
                "2",
                "Toy story",
                "Disney",
                R.drawable.toy_story,
                2002,
                "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz."
            ),
            Cartoon(
                "3",
                "Simpsons",
                "The Simpsons",
                R.drawable.simpsons,
                1999,
                "The series is a satirical depiction of American life, epitomized by the Simpson family, which consists of Homer, Marge, Bart, Lisa, and Maggie. The show is set in the fictional town of Springfield and parodies American culture and society, television, and the human condition."
            ),
            Cartoon(
                "4",
                "Happy tree friends",
                "Some",
                R.drawable.happy,
                2001,
                "description",
            ),
            Cartoon(
                "1",
                "Frozen",
                "Disney",
                R.drawable.frozen,
                2013,
                "Fearless optimist Anna teams up with rugged mountain man Kristoff and his loyal reindeer Sven and sets off on an epic journey to find her sister Elsa"
            ),
            Cartoon(
                "2",
                "Toy story",
                "Disney",
                R.drawable.toy_story,
                2002,
                "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz."
            ),
            Cartoon(
                "3",
                "Simpsons",
                "The Simpsons",
                R.drawable.simpsons,
                1999,
                "The series is a satirical depiction of American life, epitomized by the Simpson family, which consists of Homer, Marge, Bart, Lisa, and Maggie. The show is set in the fictional town of Springfield and parodies American culture and society, television, and the human condition."
            ),
            Cartoon(
                "4",
                "Happy tree friends",
                "Some",
                R.drawable.happy,
                2001,
                "description",
            )
        )
    }
}