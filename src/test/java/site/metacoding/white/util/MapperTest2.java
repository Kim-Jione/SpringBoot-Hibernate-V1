package site.metacoding.white.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
class Dog {
	private Integer id;
	private String name;
}

@NoArgsConstructor
@Setter
@Getter
class DogDto {
	private Integer id;
	private String name;

	public DogDto(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "DogDto [id=" + id + ", name=" + name + "]";
	}

}

public class MapperTest2 {

	@Test
	public void convert_test() {
		List<Dog> dogList = new ArrayList<>();
		dogList.add(new Dog(1, "강아지"));
		dogList.add(new Dog(2, "고양이"));

		// List<Dog> -> List<DogDto>
		List<DogDto> dogDtoList = new ArrayList<>();
		for (Dog dog : dogList) {
			DogDto dogDto = new DogDto();
			dogDto.setId(dog.getId());
			dogDto.setName(dog.getName());
			dogDtoList.add(dogDto);
		}

		System.out.println(dogDtoList);
	}

	@Test
	public void convert_test2() {
		List<Dog> dogList = new ArrayList<>();
		dogList.add(new Dog(1, "강아지"));
		dogList.add(new Dog(2, "고양이"));

		// List<Dog> -> List<DogDto>
		List<DogDto> dogDtoList = dogList.stream() // stream() 쓰면 어떤 컬렉션에 들어있는걸 꺼내준다 -> List에서 꺼내준다 -> Stream에 담아준다  -> 문법 3개가 나온다 for each, .map 차이는 map은 2바퀴 돌면서 머한걸 return 한다 foreach는 return 안한다, filter 필욯나걸 끄집어낸다
		// 강에 물고기가 있으면 stream 하면 강이 사라진다 그 물고기들을 옮겨서 filter 하면 원하는걸 끄집어 낼 ㅅ ㅜ있고 .map은 죽여서 return, .foreach는 죽여서 버림 스트림에 있는 dogDto 2개를 List로 바꿔치기 ㅎ마 그래서 요새는 stream을 사용한다 조금 
				.map((dog) -> new DogDto(dog.getId(), dog.getName()))
				.collect(Collectors.toList());

		System.out.println(dogDtoList);
	}
}
