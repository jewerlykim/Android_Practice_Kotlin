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
