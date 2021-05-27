# Android_Practice_Kotlin
# 1 . Fragment
# 📌 what is fragment
fragment는 스마트폰, 테블릿 등 휴대용 기기의 화면이 점점 커짐에 따라서 화면에 들어올 수 있는 화면의 구성요소가 늘어남에 따라 앱 UI의 재사용성을 위해 등장하게 되었다. 
![](https://images.velog.io/images/jewelrykim/post/7d35a9d9-f57d-4039-844b-0688fcee80a6/fragment-screen-sizes.png)
왼쪽 그림은 navigation drawer에 따라 오른쪽 grid list가 바뀌는 화면이다. 오른쪽 그림은 bottom navigation bar에 따라 화면의 list가 바뀌는 화면이다. fragment를 사용하면 액티비티의 모습을 런타임 중에 변경하기가 더 쉬워진다. 

#### Modularity
화면 구성요소를 바꿀 때마다 액티비티를 갈아치우는 방식이 아닌 하부 모듈로 fragment를 사용하게 되면서 모듈성이라는 특성을 가진다.


# 📌 fragment's life cycle
각각의 프래그먼트 인스턴스는 자신만의 라이프 사이클을 갖는다. 프래그먼트의 생명주기는 액티비티의 생명주기와 비슷하지만 조금 더 복잡한 것이 특징이다. 
![](https://images.velog.io/images/jewelrykim/post/53a4a20d-776b-4b8c-87a5-932028214fc5/fragment-view-lifecycle.png)
위 그림 이외에 onAttach()와 onDetach()의 콜백 메소드가 각각 onCreate()이전과 onDestory()이후에 존재한다.
### 👉 Lifecycle states
프래그먼트의 lifecycle state는 enum으로 정의되어있고 다음과 같다.
- INITIALIZED
- CREATED
- STARTED
- RESUMED
- DESTROYED

### 👉 onAttach()
onAttach()는 항상 생명주기 state가 시작되기 전에 호출된다. onAttach() 콜백 메소드는 프래그먼트가 FragmentManager에 추가가되고 이후에 주인 액티비티에 attach 될 때 호출된다. 이 시점에서 프래그먼트는 활성화되고 FragmentManager가 프레그먼트의 생명주기 state를 관리한다. 또한 findFragmentById()같은 FragmentMaanger 메소드가 프레그먼트를 반환한다. 

### 👉 프레그먼트 CREATED
이미 onAttach()메소드는 호출된 상태이다. onCreate() 메소드가 이후에 호출되고 이때 onSaveInstanceState()를 통해 저장된 savedInstanceState Bundle 인자를 받는다. 처음 프레그먼트가 생성되었을 때 이 인자는 null 값이지만 한번 생성이 되면 onSaveInstanceState()를 오버라이드하지 않더라도 non-null값을 갖는다. 

![](https://images.velog.io/images/jewelrykim/post/22c45535-fcfc-46ba-97b9-6bb74ea4acd3/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-05-25%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2011.24.59.png)


### 👉 프레그먼트 CREATED & 뷰 INITIALIZED
#### onCreateView()
![](https://images.velog.io/images/jewelrykim/post/ad2a7274-d54a-4ffc-a7ed-5ded7251ca04/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-05-25%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2011.54.25.png)
onCreateView() 메소드를 오버라이드해서 프래그먼트의 뷰를 만들어 낼 수 있다. 

#### onViewCreated()
![](https://images.velog.io/images/jewelrykim/post/ee5ebcad-bc52-4552-9c78-702931243f41/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-05-25%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2011.54.48.png)
프래그먼트 뷰의 초기화된 LifecycleOwner가 업데이트될 때 호출된다. 이 때 view에 대한 초기화를 하는 것이 좋다. 다음은 해당 내용에 대한 구글 developers의 예시이다. 
```swift
class LoginFragment : Fragment() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var statusTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usernameEditText = view.findViewById(R.id.username_edit_text)
        passwordEditText = view.findViewById(R.id.password_edit_text)
        loginButton = view.findViewById(R.id.login_button)
        statusTextView = view.findViewById(R.id.status_text_view)
    }

    ...
}
```

### 👉 프래그먼트, 뷰 CREATED
프래그먼트 뷰가 생성된 후에 이전의 뷰 상태가 있었던 경우에 복원될 때 이 상태로 들어선다. 이 상태에서 프래그먼트뷰와 관련된 추가 상태에 관한 것들을 복원한다. 이때 onViewStateRestored() 콜백 메서드도 같이 호출된다.
![](https://images.velog.io/images/jewelrykim/post/8a2dfa85-a8af-4622-8984-98f4596d684f/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-05-26%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.17.09.png)

### 👉 STARTED / onStart()
생성된 프래그먼트의 뷰가 사용가능하다는 것을 보장할 수 있는 상태이다.

### 👉 RESUMED / onResume()
프래그먼트가 보이고 Animator와 Transition의 효과가 끝난 상태로 유저 인터랙션을 받을 수 있는 상태이다. 

### 👉 onPause()
프래그먼트는 아직 보이는 상태이지만 유저가 프래그먼트를 떠나려고 할 때 호출된다.

### 👉 onStop() / onSaveInstanceState()
더이상 프래그먼트가 보이지 않을 때 호출된다. API 28 전후로 둘의 호출 순서가 바뀌었다. 
![](https://images.velog.io/images/jewelrykim/post/35b6bcfc-3fe1-4a2b-ba15-adf235f9218b/stop-save-order.png)

### 👉 onDestroyView() / onDestroy()
모든 애니메이션이나 화면전환이 끝나고 프래그먼트의 뷰가 window로부터 detach되었을 때 onDestoryView()가 호출된다. 이때 프래그먼트의 뷰에 참조된 것은 모두 제거가 되어야하고 프래그먼트 뷰 또한 가비지 컬렉션되어야한다.
![](https://images.velog.io/images/jewelrykim/post/7d75dbfa-0646-424f-86b5-539e09872942/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-05-26%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.29.47.png)
프래그먼트가 삭제되거나 FragmentManager가 제거되면 DESTROYED상태로 돌입하고 onDestroy()가 호출되며 프래그먼트의 생명주기가 끝이나게 된다.

### 👉 onDetach()
onDetach()는 항상 생명주기 state가 끝난 후에 호출된다. onDetach() 콜백 메소드는 onAttach() 와 반대로 FragmentManager에서 지워지고 주인 액티비티에서 detach될 때 호출되는 메소드이다. 더 이상 프레그먼트는 활성상태가 아닌 상태이고 findFragmentById()를 통해 반환되지 않는다. 





### 도움을 받은 자료
[android developers/fragments](https://developer.android.com/guide/fragments)


# 💁🏻‍♂️ 글을 시작하며
지난 글에서는 Fragment의 탄생배경부터 액티비티와 달리 따로 가지고 있는 독특한 생명주기에 대해서 자세히 알아보는 시간을 가졌다. 

> [지난 글 보러가기 - Android Fragment 1탄 - 탄생배경과 생명주기](https://velog.io/@jewelrykim/Android-Fragment-1%ED%83%84-%ED%83%84%EC%83%9D%EB%B0%B0%EA%B2%BD%EA%B3%BC-%EC%83%9D%EB%AA%85%EC%A3%BC%EA%B8%B0)

이번 글에서는 실제 Fragment를 Android Studio에서 구현해보는 시간을 가져보도록 한다. 

추가로 프로젝트를 하면서 뷰바인딩을 액티비티에서는 적용해봤지만 프래그먼트에서는 적용해본 적이 없었기 때문에 **_프래그먼트에서 뷰바인딩_**을 사용해보도록 한다. 

또, material design에서 제공하는 **_바텀 네비게이션_**을 사용해서 프래그먼트 전환을 해보려고 한다. 

# 📌 Dependency
viewBinding과 material design을 쓰기 위해서 app단 build gradle에 의존성을 추가해주도록 한다.
## viewBinding
```kotlin
android {
    ---codes---
    buildFeatures {
        viewBinding true
    }
	---codes---
}
```
viewBinding 속성을 true로 해준다.
## bottomNavigationBar
material design 홈페이지에서 최신 버전을 확인하고 의존성을 추가해준다.
```kotlin
dependencies {
	---codes---
    implementation 'com.google.android.material:material:1.3.0'
}
```

# 📌 xml
먼저 프래그먼트의 주인의 될 activity에서 FrameLayout과 bottomnavigation을 추가해준다. 참고로 전체 레이아웃은 constraintlayout으로 구현하였다.
### FrameLayout
FrameLayout 은 프래그먼트에 따라 달라지는 뷰를 가진 레이아웃이다. 이 부분에 프래그먼트들이 갈아끼워진다고 생각하면 된다.
```kotlin
    <FrameLayout
        android:id="@+id/framelayout"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@+id/bottom_nav"
        />
```
### bottom navigation bar
bottomNavigation을 완성하기 전에 바텀 네비게이션에 들어갈 menu를 먼저 만들어주도록한다. menu는 바텀 네비게이션바에서 버튼의 아이콘, label을 정의할 수 있다.
![](https://images.velog.io/images/jewelrykim/post/46ce035a-14a0-48c1-86a6-4677639e912a/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-05-27%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.38.29.png)
resource 폴더에서 Android resource Directory를 생성한다. 그 후에 resource type을 menu로 선택하면 menu 라는 resource 폴더가 생긴다. 폴더에 bottom_nav_menu.xml을 만들어보도록 하자.
```kotlin
// bottom_nav_menu.xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/menu_home"
        android:title="홈"
        android:icon="@drawable/ic_baseline_home_24" />
    <item
        android:id="@+id/menu_ranking"
        android:title="랭킹"
        android:icon="@drawable/ic_baseline_format_list_numbered_24" />
    <item
        android:id="@+id/menu_profile"
        android:title="프로필"
        android:icon="@drawable/ic_baseline_account_circle_24" />
</menu>
```
drawble은 직접 vector에서 찾아서 추가해주면 된다. title은 아이콘 아래에 label로 쓰이게 된다.
#### 다시 activity의 xml로 돌아가보자.
```kotlin
    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_nav"
        app:menu="@menu/bottom_nav_menu"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/framelayout"
        android:background="@color/white"
        app:itemIconSize="40dp"
        app:labelVisibilityMode="unlabeled"
        />
```
이렇게 추가해준다. 하나씩 뜯어보자면

 
```kotlin
   app:menu="@menu/bottom_nav_menu"

```

아까 만들었던 menu resource를 적용한다.
```kotlin
   android:background="@color/white"

```
Bar의 배경색을 흰색으로 바꾼다.
```kotlin
   app:itemIconSize="40dp"

```
아이콘의 사이즈를 조절한다.
```kotlin
   app:labelVisibilityMode="unlabeled"

```
아까 menu에서 정한 title 속성을 없애준다. 글자는 보이지 않고 아이콘만 보이게 하는 속성이다.
이렇게 완성하면 
![](https://images.velog.io/images/jewelrykim/post/2804ffc9-00a3-4052-9c11-d9a91567fd9b/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-05-27%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.47.29.png)
이와 같은 Design을 얻을 수 있다.
#### FrameLayout에 들어갈 Fragment의 xml에는 어떤 내용이 들어와도 상관없으니 예시로 각기다른 뷰로 간단히 배경색과 Textview만 포함된 xml을 3개를 만들어준다. 이는 글에서는 생략하도록 한다. xml의 파일명은 각각 fragment_home.xml, fragment_ranking.xml, fragment_profile.xml이다.

# ✏️ Fragment
HomeFragment라는 이름으로 Kotlin Class를 생성한 뒤 Fragment를 상속해준다.
```kotlin
class HomeFragment : Fragment(){
	// TODO
}
```
프래그먼트 외부인 액티비티에서 접근하고 메모리에 올라간 프래그먼트 인스턴스를 사용하기 위해 companion object를 사용한다.
```kotlin
    companion object {
        fun newInstance() : HomeFragment {
            return HomeFragment()
        }
    }
```
외부에서는 
```kotlin
HomeFragment.newInstace()
```
이렇게 접근할 수 있다.

#### viewBinding 정의
```kotlin
    private var binding : FragmentHomeBinding? = null

```
#### onCreateView
```kotlin
    // 뷰가 생성되었을 때 - 프레그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(inflater: LayoutInflater,
    container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, 
        container, false)
        
        return binding!!.root
    }
```
#### onDestroyView
프래그먼트가 GC에 의해 정리될 수 있도록 작업을 해준다.
```kotlin
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
```

# 📌 Activity
bottom navigation item이 선택되었을 때 콜백해주는 리스너를 액티비티에서 implement 하는 방식과 따로 메소드로 정의해주는 방식 두가지 방식을 모두 사용해보려고 한다.
### 1 . activity에 implement
```kotlin
class BottomNavWithFragments : AppCompatActivity(),
BottomNavigationView.OnNavigationItemSelectedListener {
	// TODO
}
```
이렇게 정의해준다.

각각의 사용할 fragment들과 viewbinding을 lateinit 시킨다.
```kotlin
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment
    
    private lateinit var binding : ActivityBottomNavWithFragmentsBinding

```
#### onCreate
```kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavWithFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.bottomNav.setOnNavigationItemSelectedListener(this)
    }
```
onNavigationItemSelected 메소드를 override 해준다.
```kotlin
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(it.itemId){
            R.id.menu_home -> {
                homeFragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, homeFragment).commit()
            }
            R.id.menu_ranking -> {
                rankingFragment = RankingFragment.newInstance()
                supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, rankingFragment).commit()
            }
            R.id.menu_profile -> {
                profileFragment = ProfileFragment.newInstance()
                supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, profileFragment).commit()
            }
        }
        
        return true
    }
```
replace는 기존에 있던 fragment를 교체한다는 뜻이다. 처음 화면을 넣으려면 onCreate에서 add로 추가해준다.

### 2 . 따로 메소드 만들기
이때는 activity에 리스너를 implement 하지 않는다.
```kotlin
    private val onNavigationItemSelectedListener = BottomNavigationView
    .OnNavigationItemSelectedListener{
        when(it.itemId){
            R.id.menu_home -> {
                homeFragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, homeFragment).commit()
            }
            R.id.menu_ranking -> {
                rankingFragment = RankingFragment.newInstance()
                supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, rankingFragment).commit()
            }
            R.id.menu_profile -> {
                profileFragment = ProfileFragment.newInstance()
                supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, profileFragment).commit()
            }
        }
        true
    }
```
#### onCreate
```kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavWithFragmentsBinding
        .inflate(layoutInflater)
        setContentView(binding.root)

        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction()
        .add(R.id.framelayout, homeFragment).commit()
        
        binding.bottomNav
        .setOnNavigationItemSelectedListener
        (onNavigationItemSelectedListener)
    }
```


완성했다. 아래 영상은 기기에서 실행했을 때 영상이다. 

![](https://images.velog.io/images/jewelrykim/post/3b8f4f7b-e73c-43b9-ab0e-3f1d42f0371c/fragment%E1%84%83%E1%85%A9%E1%86%BC%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%A7%E1%86%BC%E1%84%89%E1%85%A1%E1%86%BC.gif)


# 🙋‍♂️ 글을 마치며
지난 프로젝트를 하면서 Fragment를 사용하지 못해서 아쉬움이 남았었는데 이렇게 예제를 작성해보면서 아쉬움이 조금은 달래졌다. 메모리의 효율적 사용과 모듈을 재사용할 수 있는 프래그먼트의 장점을 생각하면 안드로이드 프로그래밍에 도움이 될 것이라 믿는다. 

다음 글에서부터는 프래그먼트에서의 데이터 전송에 대해서 알아볼 예정이다. 그리고 했었던 프로젝트에서 액티비티에서 프래그먼트로 바꿀 수 있는 부분이 있는지 확인하고 바꾸는 작업을 시작해보려고 한다. 대부분의 예제자료를 아래 youtube 채널에서 튜토리얼을 보며 도움을 받았는데 이렇게 지적 재산을 기부해주는 개발자들에게 감사의 말씀을 표하며 나도 그들 중 하나가 될 것을 다짐하며 이번 글을 마치도록 한다. 😍



# 👍 도움받은 자료
[개발하는 정대리 - youtube](https://www.youtube.com/channel/UCutO2H_AVmWHbzvE92rpxjA)
[홍드로이드 - youtube](https://www.youtube.com/channel/UCEdsGM2ALcUGkUCNSMAthLg)
