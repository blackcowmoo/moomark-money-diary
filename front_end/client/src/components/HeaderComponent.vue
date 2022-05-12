<template>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
            <a class="navbar-brand" href="/">AllowanceChart</a>
            <!-- <b-link to="/" class="navbar-brand">AllowanceChart</b-link> -->
            <button class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <router-link class="nav-link" to="income">Income</router-link>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#"
                    tabindex="-1" aria-disabled="true">Spending</a>
                </li>
                </ul>
            </div>
            </div>
        </nav>
    </header>
</template>
