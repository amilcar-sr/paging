# Paging Library - Usage example
This repo is just an usage example of the [Paging Library released by Android](https://developer.android.com/topic/libraries/architecture/paging/) with simple network requests. I wanted to make this small repo to practice/understand the way this library works and to provide a simpler sample because [Android's Sample](https://github.com/googlesamples/android-architecture-components/tree/master/PagingWithNetworkSample) is kind of complex 😅.


## ⚠️ API KEY (VERY IMPORTANT)
In order to make this example, I used a super cool sample api called ["The Movie Database API"](https://www.themoviedb.org/) 😃 so I created an account with them and got a **SECRET API KEY** to use their endpoints, and you'll have to do the same if you want to give this example a try yourself 🙂.

You just need to get an **API KEY** following [these instructions](https://developers.themoviedb.org/3/getting-started/introduction) and paste it in the **NetworkManager** class (it should be the only thing giving you compiling errors in the project, let me know if it isn't 🙏🏻) replacing *PrivateConstants.API_KEY* and you'll be ready to go!

## Paging's Purpose
This library simplifies greatly the code needed to implement paging into our app, it takes care of triggering callbacks in order to fetch the appropriate pages from our endpoint/database and also provides a way to integrate its DataSources with LiveData wich **saves us A LOT of boilerplate code** when appending new results into the Adapter's list 👌🏻🧐.

## App Behaviour
I didn't add any actions to the sample app because I wanted to focus on the paging scrolling part and take the time to comment without adding unnecesary code that might just get in the way of the guys trying to get a hold on this new library.

Maybe I'll add a new repo with Database loading and different kinds of DataSource later. In the meantime please feel free to clone this repo and/or add comments to my code, I'll appreciate the feedback 😄.

## Resources
In case you want to read the documentation I read in order to make this sample (it's basically Android's), I'll leave the urls in here. Good Luck ✌🏻and Happy Coding 👨🏻‍💻.
- [Paging Overview](https://developer.android.com/topic/libraries/architecture/paging/)
- [UI Considerations](https://developer.android.com/topic/libraries/architecture/paging/ui)
- [Data Considerations](https://developer.android.com/topic/libraries/architecture/paging/data#custom-data-source)
- [PagedListAdapter](https://developer.android.com/reference/android/arch/paging/PagedListAdapter)
- [Paging Dependency for Android X](https://developer.android.com/jetpack/androidx/releases/paging)
- [API Endpoint](https://developers.themoviedb.org/3/movies/get-movie-details)
