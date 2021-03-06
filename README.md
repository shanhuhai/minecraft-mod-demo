


## 基本概念

**不同的 slide**
- 物理客户端(Physical Client)：物理客户端就是你启动Minecraft时运行的整个程序。游戏运行周期中所有的线程，进程，服务，都是物理客户端的一部分。
- 物理服务端(Physical Server)：通常称之为专用服务器(Dedicated Server)。物理服务端就是你运行 minecraft_server.jar 之类服务器时的整个程序，它不会有可操作的GUI。
- 逻辑服务端(Logical Server)：逻辑服务端运行着游戏的逻辑：生物生成、天气、更新背包、生命、AI等游戏机制。逻辑服务端存在于物理服务端之中，但它也可以和逻辑客户端一齐运行在物理客户端之中，作为一个单人游戏世界。逻辑服务端永远运行在一个叫做 Server Thread 的线程中。
- 逻辑客户端(Logical Client)：逻辑客户端从玩家那里接收输入，并将其转发至逻辑服务端中。除此之外，它也同样从逻辑服务端那里接收信息，并将其以图形化的方式呈现给玩家。逻辑客户端运行在 Client Thread 当中，当然通常一些其它的线程也会生成来处理音频和区块渲染等工作。

**world.isRemote**

这个boolean检查是最常用的检查Side的方式。对一个 World 对象查询这个值将会得到这个世界所处的逻辑端。也就是说，当这个值为 true 的时候，世界正在运行在逻辑客户端内。如果这个值为 false，世界正在运行在逻辑服务器上。在物理服务端中这个值永远为 false，但是 false 并不意味着世界一定在物理服务端中，因为这个值也可以在物理客户端的逻辑服务端内为 false（即单人游戏世界中）。

你可以使用这个来检查游戏逻辑和其他机制是否需要被运行。比如说，如果你想要让玩家在点击你的方块时受到伤害，或者让你的机器加工泥土为钻石，你首先需要确认 world.isRemote 为 false。将游戏逻辑应用到逻辑客户端将轻则造成不同步（幽灵实体、数据不同步等），重则崩溃游戏。

这个检查将会成为你的首选。除了Proxy之外，很少你会需要其它判定Side和调整行为的方式。
