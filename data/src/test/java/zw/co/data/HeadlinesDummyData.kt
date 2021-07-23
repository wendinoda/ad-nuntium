package zw.co.data

import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.HeadlinesDataModel
import zw.co.data.model.SourceHeadlineDataModel
import zw.co.domain.model.Articles
import zw.co.domain.model.Headlines
import zw.co.domain.model.SourceHeadline
import zw.co.test_module.buildDate

object HeadlinesDummyData {
    val headlinesArray1 = arrayOf(
        HeadlinesDataModel(
            status = "ok",
            totalResults = 2,
            articles = listOf(
                ArticlesDataModel(
                    author = "John Doe",
                    title = "Olympic opening ceremony",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    url = "https://www.lipsum.com/",
                    urlToImage = "urlToImage",
                    publishedAt = buildDate("2021-07-22T12:49:03Z"),
                    content = "The creative director of the opening ceremony of the Olympic Games in Tokyo was fired on Thursday, one day before the event is set to take place. Kentaro Kobayashi, who had previously been a member o… ",
                    source = SourceHeadlineDataModel(
                        id = "the-guardian",
                        name = "The Guardian"
                    )
                ),
                ArticlesDataModel(
                    author = "Jane Doe",
                    title = "Astronomers Confirm Discovery of Moon-Forming Disk Around Young Exoplanet",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    url = "https://www.lipsum.com/",
                    urlToImage = "urlToImage",
                    publishedAt = buildDate("2021-07-22T12:49:03Z"),
                    content = "Two years ago, astronomers spotted an apparent circumplanetary disk around a planet outside of our solar system, but they couldnt be certain",
                    source = SourceHeadlineDataModel(
                        id = "the-guardian",
                        name = "The Guardian"
                    )
                )
            ),
        ),
        Headlines(
            status = "ok",
            totalResults = 2,
            articles = listOf(
                Articles(
                    author = "John Doe",
                    title = "Olympic opening ceremony",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    url = "https://www.lipsum.com/",
                    urlToImage = "urlToImage",
                    publishedAt = buildDate("2021-07-22T12:49:03Z"),
                    content = "The creative director of the opening ceremony of the Olympic Games in Tokyo was fired on Thursday, one day before the event is set to take place. Kentaro Kobayashi, who had previously been a member o… ",
                    source = SourceHeadline(
                        id = "the-guardian",
                        name = "The Guardian"
                    )
                ),
                Articles(
                    author = "Jane Doe",
                    title = "Astronomers Confirm Discovery of Moon-Forming Disk Around Young Exoplanet",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    url = "https://www.lipsum.com/",
                    urlToImage = "urlToImage",
                    publishedAt = buildDate("2021-07-22T12:49:03Z"),
                    content = "Two years ago, astronomers spotted an apparent circumplanetary disk around a planet outside of our solar system, but they couldnt be certain",
                    source = SourceHeadline(
                        id = "the-guardian",
                        name = "The Guardian"
                    )
                )
            ),
        )
    )

    val headlinesArray2 = arrayOf(
        HeadlinesDataModel(
            status = "ok",
            totalResults = 2,
            articles = listOf(
                ArticlesDataModel(
                    author = "John Doe",
                    title = "Olympic opening ceremony",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    url = "https://www.lipsum.com/",
                    urlToImage = "urlToImage",
                    publishedAt = buildDate("2021-07-22T12:49:03Z"),
                    content = "The creative director of the opening ceremony of the Olympic Games in Tokyo was fired on Thursday, one day before the event is set to take place. Kentaro Kobayashi, who had previously been a member o… ",
                    source = SourceHeadlineDataModel(
                        id = "the-guardian",
                        name = "The Guardian"
                    )
                ),
                ArticlesDataModel(
                    author = "Jane Doe",
                    title = "Astronomers Confirm Discovery of Moon-Forming Disk Around Young Exoplanet",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    url = "https://www.lipsum.com/",
                    urlToImage = "urlToImage",
                    publishedAt = buildDate("2021-07-22T12:49:03Z"),
                    content = "Two years ago, astronomers spotted an apparent circumplanetary disk around a planet outside of our solar system, but they couldnt be certain",
                    source = SourceHeadlineDataModel(
                        id = "the-guardian",
                        name = "The Guardian"
                    )
                )
            ),
        ),
        Headlines(
            status = "ok",
            totalResults = 2,
            articles = listOf(
                Articles(
                    author = "John Doe",
                    title = "Olympic opening ceremony",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    url = "https://www.lipsum.com/",
                    urlToImage = "urlToImage",
                    publishedAt = buildDate("2021-07-22T12:49:03Z"),
                    content = "The creative director of the opening ceremony of the Olympic Games in Tokyo was fired on Thursday, one day before the event is set to take place. Kentaro Kobayashi, who had previously been a member o… ",
                    source = SourceHeadline(
                        id = "the-guardian",
                        name = "The Guardian"
                    )
                ),
                Articles(
                    author = "Jane Doe",
                    title = "Astronomers Confirm Discovery of Moon-Forming Disk Around Young Exoplanet",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    url = "https://www.lipsum.com/",
                    urlToImage = "urlToImage",
                    publishedAt = buildDate("2021-07-22T12:49:03Z"),
                    content = "Two years ago, astronomers spotted an apparent circumplanetary disk around a planet outside of our solar system, but they couldnt be certain",
                    source = SourceHeadline(
                        id = "the-guardian",
                        name = "The Guardian"
                    )
                )
            ),
        )
    )
}