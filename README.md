# Android_Practice_Kotlin
# 1 . Fragment
## what is fragment
fragment는 스마트폰, 테블릿 등 휴대용 기기의 화면이 점점 커짐에 따라서 화면에 들어올 수 있는 화면의 구성요소가 늘어남에 따라 앱 UI의 재사용성을 위해 등장하게 되었다. 
![](https://images.velog.io/images/jewelrykim/post/7d35a9d9-f57d-4039-844b-0688fcee80a6/fragment-screen-sizes.png)
왼쪽 그림은 navigation drawer에 따라 오른쪽 grid list가 바뀌는 화면이다. 오른쪽 그림은 bottom navigation bar에 따라 화면의 list가 바뀌는 화면이다. fragment를 사용하면 액티비티의 모습을 런타임 중에 변경하기가 더 쉬워진다. 

#### Modularity
화면 구성요소를 바꿀 때마다 액티비티를 갈아치우는 방식이 아닌 하부 모듈로 fragment를 사용하게 되면서 모듈성이라는 특성을 가진다.
